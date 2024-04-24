<?php

namespace App\Telegram;

class TelegramApiImpl implements TelegramApi {
    const ENDPOINT = 'https://api.telegram.org/bot';
    private int $offset;
    private string $token;

    public function __construct(string $token)
    {
        $this->token = $token;
    }

    public function getMessages(int $offset): array
    {
        $url = self::ENDPOINT . $this->token . '/getUpdates?timeout=1';
        $result = [];

        while (true) {
            $ch = curl_init("{$url}&offset={$offset}");

//            curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type:application/json')); // Set the content type to application/json
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); // Return the response instead of printing it
            curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
            curl_setopt($ch, CURLOPT_HEADER, false);

            $response = json_decode(curl_exec($ch), true);

            if (!$response['ok'] || empty($response['result'])) break;
            foreach ($response['result'] as $data) {
                $result[$data['message']['chat']['id']] = [...$result[$data['message']['chat']['id']] ?? [], $data['message']['text']];
                $offset = $data['update_id'] + 1;
            }
            curl_close($ch);

            if (count($response['result']) < 100) break;
        }

        return [
            'offset' => $offset,
            'result' => $result,
        ];
    }

    public function sendMessage(string $chatId, string $text): void
    {
        $url = self::ENDPOINT . $this->token . '/sendMessage';

        $data = [
            'chat_id' => 610941258,
            'text' => 'asd',
        ];

        $ch = curl_init($url);

        curl_setopt($ch, CURLOPT_POST, 1);
        curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data, '', '&'));
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
        curl_setopt($ch, CURLOPT_HEADER, false);
        curl_exec($ch);
        curl_close($ch);
    }
}