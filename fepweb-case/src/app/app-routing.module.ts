import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListaParticipantesComponent } from './lista-participantes/lista-participantes.component';
import { DetalherParticipantesComponent } from './detalher-participantes/detalher-participantes.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent,
    data: {
      title: 'Home'
    }
  },
  {
    path: 'listar', component: ListaParticipantesComponent,
    data: {
      title: 'Listar'
    }
  },
  {
    path: 'editar/:id', component: DetalherParticipantesComponent,
    data: {
      title: 'Editar'
    }
  },
  {
    path: '**',  redirectTo: '/'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
