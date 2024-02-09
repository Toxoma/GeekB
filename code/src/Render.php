<?php

namespace Geekbrains\Application1;

use Twig\Loader\FilesystemLoader;
use Twig\Environment;
use Twig\Extra\CssInliner\CssInlinerExtension;

class Render {

    private string $viewFolder = '/src/Views/';
    private FilesystemLoader $loader;
    private Environment $environment;


    public function __construct(){

        $this->loader = new FilesystemLoader(dirname(__DIR__) . $this->viewFolder);
        $this->environment = new Environment($this->loader, [
           // 'cache' => $_SERVER['DOCUMENT_ROOT'].'/cache/',
        ]);
        $this->environment->addExtension(new CssInlinerExtension());
    }

    public function renderPage(string $contentTemplateName = 'page-index.twig', array $templateVariables = [], string $cssTemplateName = '',) {
        $template = $this->environment->load('main.twig');
        
        $templateVariables['content_template_name'] = $contentTemplateName;
        $templateVariables['css_template_name'] = '/css/'.$cssTemplateName;
        $templateVariables['title'] = $templateVariables['title'] ?: 'имя страницы';

        return $template->render($templateVariables);
    }

    public function renderErrorPage(array $templateVariables = []) {
        http_response_code(404);
        $template = $this->environment->load('error_page.twig');
        $templateVariables['title'] = $templateVariables['title'] ?: 'имя страницы';
        return $template->render($templateVariables);
    }
}
