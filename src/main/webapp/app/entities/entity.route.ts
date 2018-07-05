import { Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { departmentMgmtRoute } from './';
const ENTITY_ROUTES = [...departmentMgmtRoute];

export const entityState: Routes = [
    {
        path: 'entities',
        data: {
            authorities: ['ROLE_ADMIN']
        },
        canActivate: [UserRouteAccessService],
        children: ENTITY_ROUTES
    }
];
