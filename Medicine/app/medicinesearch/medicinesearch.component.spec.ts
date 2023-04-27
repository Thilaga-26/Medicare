import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicinesearchComponent } from './medicinesearch.component';

describe('MedicinesearchComponent', () => {
  let component: MedicinesearchComponent;
  let fixture: ComponentFixture<MedicinesearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MedicinesearchComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MedicinesearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
