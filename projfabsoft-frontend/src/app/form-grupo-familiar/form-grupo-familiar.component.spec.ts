import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormGrupoFamiliarComponent } from './form-grupo-familiar.component';

describe('FormGrupoFamiliarComponent', () => {
  let component: FormGrupoFamiliarComponent;
  let fixture: ComponentFixture<FormGrupoFamiliarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormGrupoFamiliarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormGrupoFamiliarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
