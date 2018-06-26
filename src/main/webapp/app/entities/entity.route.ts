import { Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core';

const ADMIN_ROUTES = [];

export const entityState: Routes = [
    {
        path: '',
        data: {
            authorities: ['ROLE_ADMIN']
        },
        canActivate: [true],
        children: ADMIN_ROUTES
    }
];
