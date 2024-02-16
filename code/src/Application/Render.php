<?php

namespace Geekbrains\Application1\Application;

use Exception;
use Twig\Loader\FilesystemLoader;
use Twig\Environment;

class Render {

    private string $viewFolder = '/src/Domain/Views/';
    private FilesystemLoader $loader;
    private Environment $environment;


    public function __construct(){
        $this->loader = new FilesystemLoader($_SERVER['DOCUMENT_ROOT'] . $this->viewFolder);
        $this->environment = new Environment($this->loader, [
//            'cache' => $_SERVER['DOCUMENT_ROOT'].'/cache/',
        ]);
    }

    public function renderPage(string $contentTemplateName = 'page-index.tpl', array $templateVariables = []) {
        $template = $this->environment->load('main.tpl');
        
        $templateVariables['content_template_name'] = $contentTemplateName;
 
        return $template->render($templateVariables);
    }

    public static function renderExceptionPage(Exception $ex): string {
        $loader = new FilesystemLoader($_SERVER['DOCUMENT_ROOT'] . '/src/Domain/Views/');
        $environment = new Environment($loader, [
//            'cache' => $_SERVER['DOCUMENT_ROOT'].'/cache/',
        ]);
        $template = $environment->load('main.tpl');
        $templateVariables['content_template_name'] = 'error.tpl';
        $templateVariables['error_message'] = $ex->getMessage();
        return $template->render($templateVariables);
    }
}