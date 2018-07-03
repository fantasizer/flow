import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { User } from 'app/core';

@Component({
    selector: 'jhi-department-mgmt-detail',
    templateUrl: './department-management.component.html'
})
export class DepartmentMgmtDetailComponent implements OnInit {
    user: User;

    constructor(private route: ActivatedRoute) {}

    ngOnInit() {
        this.route.data.subscribe(({ user }) => {
            this.user = user.body ? user.body : user;
        });
    }
}
