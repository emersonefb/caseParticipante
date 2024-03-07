import { SelectionModel } from '@angular/cdk/collections';
import { Component, ViewChild, inject } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { GlobalStateService } from '../core/global-state-service.service';
import { MatTableDataSource } from '@angular/material/table';
import { ParticipanteSearchDTO } from '../model/ParticipanteSearchDTO';
import { Content } from '../model/Content';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SnackBarComponent } from '../snack-bar/snack-bar.component';

@Component({
  selector: 'app-lista-participantes',
  templateUrl: './lista-participantes.component.html',
  styleUrl: './lista-participantes.component.css'
})
export class ListaParticipantesComponent {

  private router= inject( Router);
  private global= inject(GlobalStateService);
  private _snackBar= inject(MatSnackBar);
  
  displayedColumns: string[] = ['select','codigo','codigoExterno','nome','CPF','Telefone','Assinadigital','Status'];
  @ViewChild(MatPaginator, {static: true}) paginator!: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort!: MatSort;

  selection = new SelectionModel <Content> ( true , []);
  selectedRow!: Content;
  entitiesSelect:  Content[] = [];
  dataSource = new MatTableDataSource<Content>() ;
  length = 50;
  pageSize = 8;
  pageIndex = 0;
  pageSizeOptions = [4, 8, 10, 20];
  hidePageSize = false;
  showPageSizeOptions = true;
  showFirstLastButtons = true;
  disabled = false;
  pageEvent: PageEvent = new PageEvent;

  ngOnInit() {
    this.getDataSource();
  }

  rowClicked(codigo: number) {
    this.openSnackBar('Processando');
    this.router.navigate([ 'editar/'+ codigo]);
  }

  handlePageEvent(e: PageEvent) {
    this.pageEvent = e;
    this.length = e.length;
    this.pageSize = e.pageSize;
    this.pageIndex = e.pageIndex;
    this.getDataSource();
  }

  setPageSizeOptions(setPageSizeOptionsInput: string) {
    if (setPageSizeOptionsInput) {
      this.pageSizeOptions = setPageSizeOptionsInput.split(',').map(str => +str);
    }
  }
  getDataSource(){
    this.global.sendPost('Participante/listar', {size: this.pageSize, page: this.pageIndex}).subscribe(resposta => {
      this.dataSource.data = resposta.content;
      this.length = resposta.total_elements;
      
    });
  }

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  toggleAllRows() {
    if (this.isAllSelected()) {
      this.selection.clear();
      return;
    }
    this.selection.select(...this.dataSource.data);
  }

  /** The label for the checkbox on the passed row */
  checkboxLabel(row?: Content): string {
    if (!row) {
      return `${this.isAllSelected() ? 'deselect' : 'select'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.codigo + 1}`;
  }
  deletandoLista : number[] = []; 

  excluir(){
    this.openSnackBar('Processando');
    this.selection.selected.forEach(deletando => {
      this.deletandoLista.push(deletando.codigo);
    })
    this.global.excluirLista('Participante/deletarLista', this.deletandoLista).subscribe(resposta => {
      this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => {
        this.router.navigate(['listar']);
      }); 
    });
    
    this.openSnackBar('Deletados');
    
  }

  adicionar(){
    this.router.navigate([ 'editar/0']);
  }
  
  openSnackBar(message: string) {
    this._snackBar.openFromComponent(SnackBarComponent, {
      data: message,
      duration: 2 * 1000,
      horizontalPosition: 'center',
      verticalPosition: 'top',
      panelClass: ['warning']
    });
  }
}
