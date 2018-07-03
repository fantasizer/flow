import { Routes } from '@angular/router';

import { departmentMgmtRoute } from './';

const ADMIN_ROUTES = [...departmentMgmtRoute];

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
