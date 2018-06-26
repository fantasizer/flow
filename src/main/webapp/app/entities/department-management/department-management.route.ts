import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';

import { Principal, Department, DepartmentService } from 'app/core';
import { DepartmentMgmtComponent } from './department-management.component';

@Injectable({ providedIn: 'root' })
export class DepartmentResolve implements CanActivate {
    constructor(private principal: Principal) {}

    canActivate() {
        return this.principal.identity().then(account => this.principal.hasAnyAuthority(['ROLE_ADMIN']));
    }
}

@Injectable({ providedIn: 'root' })
export class DepartmentMgmtResolve implements Resolve<any> {
    constructor(private service: DepartmentService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        return new Department();
    }
}

export const departmnetMgmtRoute: Routes = [
    {
        path: 'department-management',
        component: DepartmentMgmtComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            pageTitle: 'userManagement.home.title',
            defaultSort: 'id,asc'
        }
    }
];
