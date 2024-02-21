<?php

namespace Geekbrains\Application1\Domain\Controllers;

use Geekbrains\Application1\Application\Application;

class AbstractController {

    protected array $actionsPermissions = [];
    
    public function getUserRoles(): array{
        $roles = [];
        $roles[] = 'user';
        return $roles;
    }

    public function getActionsPermissions(string $methodName): array {
        return $this->actionsPermissions[$methodName] ?? [];
    }
}