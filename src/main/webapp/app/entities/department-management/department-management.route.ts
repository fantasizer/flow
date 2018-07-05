import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';
import {  JhiResolvePagingParams } from 'ng-jhipster';
import { DepartmentMgmtComponent } from './department-management.component';
import { DepartmentUpdateComponent } from './department-management-update.component';
import { Principal, Department, DepartmentService } from 'app/core';

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
        console.log('DepartmentMgmtResolve');
        const id = route.params['departmentId'] ? route.params['departmentId'] : null;
        if (id) {
            // return this.service.find(id);
            return new Department();
        }
        return new Department();
    }
}

export const departmentMgmtRoute: Routes = [
    {
        path: 'department-management',
        component: DepartmentMgmtComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            pageTitle: 'departManagement.home.title',
            defaultSort: 'id,asc'
        }
    },
    {
        path: 'department-management/new',
        component: DepartmentUpdateComponent,
        resolve: {
            user: DepartmentMgmtResolve
        }
    }
];
