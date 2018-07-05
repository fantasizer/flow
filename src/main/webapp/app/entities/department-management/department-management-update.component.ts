import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Department, DepartmentService } from 'app/core';
import { FormsModule } from '@angular/forms';

@Component({
    selector: 'jhi-department-mgmt-update',
    templateUrl: './department-management-update.component.html'
})
export class DepartmentUpdateComponent implements OnInit {
    department: Department;
    // languages: any[];
    isSaving: boolean;

    constructor(
        private departmentService: DepartmentService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    ngOnInit() {
        this.isSaving = false;
        console.log('department update component oninit');
        console.log('route:', this.route);
        console.log(this.route.data);
        this.route.data.subscribe(({ department }) => {
            this.department = department ? department : department;
        });
        console.log('department:', this.department);
        if(typeof(this.department) == 'undefined'){
            this.department = new Department();
        }
        console.log('department:', this.department);
    }

    previousState() {
        this.router.navigate(['/entities/department-management']);
    }

    save() {
        this.isSaving = true;
        if (this.department.id !== null) {
            this.departmentService.update(this.department).subscribe(response => this.onSaveSuccess(response), () => this.onSaveError());
        } else {
            this.departmentService.create(this.department).subscribe(response => this.onSaveSuccess(response), () => this.onSaveError());
        }
    }

    private onSaveSuccess(result) {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
}
