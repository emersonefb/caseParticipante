import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalherParticipantesComponent } from './detalher-participantes.component';

describe('DetalherParticipantesComponent', () => {
  let component: DetalherParticipantesComponent;
  let fixture: ComponentFixture<DetalherParticipantesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DetalherParticipantesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetalherParticipantesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
