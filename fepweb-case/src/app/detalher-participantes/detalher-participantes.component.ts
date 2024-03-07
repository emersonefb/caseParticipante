import {Component,  inject} from '@angular/core';
import {
  AbstractControl,
  FormControl,
  Validators,
  NonNullableFormBuilder,
} from '@angular/forms';
import Validation from '../utils/Validation';
import { ActivatedRoute, Router } from '@angular/router';
import { GlobalStateService } from '../core/global-state-service.service';
import { Observable} from 'rxjs';
import { map, startWith} from 'rxjs/operators';
import { ParticipanteDTO } from '../model/ParticipanteDTO';
import { EnderecoList } from '../model/EnderecoList';
import { DateAdapter } from '@angular/material/core';
import { DatePipe } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SnackBarComponent } from '../snack-bar/snack-bar.component';


@Component({
  selector: 'app-detalher-participantes',
  templateUrl: './detalher-participantes.component.html',
  styleUrl: './detalher-participantes.component.css',
})
export class DetalherParticipantesComponent {

cadastroNovo: boolean = true;


  private global= inject(GlobalStateService);
  private router = inject(Router)
  private routeActive = inject(ActivatedRoute)
  private formBuilder= inject(NonNullableFormBuilder);
  private dateAdapter= inject(DateAdapter<Date>);
  private datepipe= inject(DatePipe);
  private _snackBar= inject(MatSnackBar);

  openSnackBar(message: string) {
    this._snackBar.openFromComponent(SnackBarComponent, {
      data: message,
      duration: 2 * 1000,
      horizontalPosition: 'center',
      verticalPosition: 'top',
      panelClass: ['warning']
    });
  }

  constructor() {
    this.dateAdapter.setLocale('pr-BR'); 
    let id = this.routeActive.snapshot.params['id']
    if(id !== '0'){
      this.goTohttp(id);
      this.cadastroNovo = false;
    } else {
      this.onReset();
      this.cadastroNovo = true;
    }

    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value || '')),
    );
    
  }

  public participanteDTO: ParticipanteDTO = {
    codigo: 0,
    codigoExterno: '',
    condicaoPessoal: '',
    conjuge: '',
    cpf: '',
    dataNascimento: '',
    documentoIdentificacao: '',
    email: '',
    estadoCivil: '',
    habilitaEnvioToken: false,
    obsSemImpact: '',
    ppe: false,
    sexo: '',
    status: false,
    telefone: '',
    validateFichaCadastral: ''
  };
  sexoCombo: String[] = [
    'Masculino','Feminino', 'não declarar',
  ];

  estadoCivilCombo: String[] = [
    'Casado','Separado', 'Solteiro', 'Viuvo', 'Outros'
  ];

  condicaoPessoalCombo: String[] = [
    'condicaoPessoal', 'Outros'
  ];

  myControl = new FormControl('');
  options: string[] = [];
  filteredOptions: Observable<string[]>;

  form = this.formBuilder.group(
    {
      codigo: [''],
      codigoExterno: ['', Validators.required],
      nome: ['',[Validators.required],],
      email: ['', [Validators.email, Validators.email]],
      cpf: ['', Validators.required],
      cpfAplicavel: [false],
      sexo: ['', Validators.required],
      estadoCivil: ['', Validators.required],
      conjuge: [''],
      documentoIdentificacao: [''],
      obsSemImpact: [''],
      condicaoPessoal: [''],
      telefone: [''],
      celular: ['', Validators.required],
      validateFichaCadastral: [''],
      dataNascimento: ['', Validators.required],
      habilitaEnvioToken: [false],
      status: [false],
      ppe: [false],
      assinaDigital: [false],
    }
  );

  getErrorMessage(campo : string) {
    if (this.form.controls.email.hasError('required')) {
      return 'You must enter a value';
    }if (this.form.controls.nome.hasError('required')) {
      return 'username is required';
    }if (this.form.controls.nome.hasError('minlength')) {
      return 'Username must be at least 6 characters';
    }if (this.form.controls.nome.hasError('maxlength')) {
      return 'Username must not exceed 20 characters';
    }

    return this.form.controls.email.hasError('email') ? 'Not a valid email' : '';
  }
  
  submitted = false;
  
  ngOnInit(): void {
    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value || '')),
    );
  }


  _filter(val: string): string[] {
    if(val == ''){
      return this.options;
    }
    this.goPopulateOptios(val);
     return this.options;
   }  

  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  onSubmit(): void {
    this.submitted = true;
    this.openSnackBar('Processando');
    
    if (this.form.invalid) {
      this.openSnackBar('Verifique os campos obrigatórios');
      return;
    }
    
    this.goTohttpSave(this.toPartecipente(this.form.value, this.myControl.value));
  }
  
 
  toPartecipente(value: Partial<{ codigo: string; codigoExterno: string; nome: string; email: string; cpf: string; cpfAplicavel: boolean; sexo: string; estadoCivil: string; conjuge: string; documentoIdentificacao: string; obsSemImpact: string; condicaoPessoal: string; telefone: string; celular: string; validateFichaCadastral: string; dataNascimento: string; habilitaEnvioToken: boolean; status: boolean; ppe: boolean; assinaDigital: boolean; }>, conjuge: string | null): ParticipanteDTO {
    
    let cod = 0;
    if(value.codigo !== '0'){
      cod = parseInt(value.codigo as string);
    }
    let conjugeValue = '';
    if(conjuge){
      conjugeValue = conjuge;
    }

    let dataNascimentoDate = this.datepipe.transform(this.form.value.dataNascimento, 'yyyy-MM-dd');
    var dataNascimento = '';
    if(dataNascimentoDate?.toString !== undefined){
      dataNascimento = dataNascimentoDate as string;
    } 
    let validateFichaCadastralDate = this.datepipe.transform(this.form.value.validateFichaCadastral, 'yyyy-MM-dd');
    var validateFichaCadastral = '';
    if(validateFichaCadastralDate?.toString !== undefined){
      validateFichaCadastral = validateFichaCadastralDate as string;
    } 
   
    this.participanteDTO.nome=value.nome;
    this.participanteDTO.codigo = cod;
    this.participanteDTO.codigoExterno=value.codigoExterno;
    this.participanteDTO.condicaoPessoal= value.condicaoPessoal;
    this.participanteDTO.conjuge = conjugeValue;
    this.participanteDTO.cpf = value.cpf;
    this.participanteDTO.dataNascimento = dataNascimento;
    this.participanteDTO.documentoIdentificacao =value.documentoIdentificacao;
    this.participanteDTO.email =value.email;
    this.participanteDTO.estadoCivil = value.estadoCivil;
    this.participanteDTO.habilitaEnvioToken = value.habilitaEnvioToken;
    this.participanteDTO.obsSemImpact = value.obsSemImpact;
    this.participanteDTO.ppe = value.ppe;
    this.participanteDTO.sexo = value.sexo;
    this.participanteDTO.status = value.status;
    this.participanteDTO.telefone = value.telefone;
    this.participanteDTO.celular = value.celular;
    this.participanteDTO.validateFichaCadastral = validateFichaCadastral;
    this.participanteDTO.assinaDigital = value.assinaDigital;
    this.participanteDTO.cpfAplicavel = value.cpfAplicavel;
    
    return this.participanteDTO
  }

  onReset(): void {
    console.log(this.form);
    this.submitted = false;
    this.form.reset();
    this.goTohttp(0);
  }
 
  goTohttpSave(json: ParticipanteDTO) {

    if(json.codigo === 0){
      this.global.sendPost('Participante/cadastrar', json).subscribe(resposta => {
        this.popularForm(resposta);
        this.openSnackBar('Cadastrado');
      });
    } else {
      this.global.sendPut('Participante/update', json).subscribe(resposta => {
        this.popularForm(resposta);
        this.openSnackBar('Atualizado');
      });
    }
  
    this.back();
  }
  
  back(){
    this.router.navigate(['listar']);
  }

  goTohttp(id: number){
    this.global.getParticipanteById('Participante/buscar/'+ id).subscribe(resposta => {
      this.popularForm(resposta);
    });
  }

  private popularForm(resposta: any) {
    this.form.patchValue({
      codigo: resposta.codigo,
      codigoExterno: resposta.codigoExterno,
      nome: resposta.nome,
      email: resposta.email,
      cpf: resposta.cpf,
      cpfAplicavel: resposta.cpfAplicavel,
      sexo: resposta.sexo,
      estadoCivil: resposta.estadoCivil,
      conjuge: resposta.conjuge,
      documentoIdentificacao: resposta.documentoIdentificacao,
      obsSemImpact: resposta.obsSemImpact,
      condicaoPessoal: resposta.condicaoPessoal,
      telefone: resposta.telefone,
      celular: resposta.celular,
      validateFichaCadastral: resposta.validateFichaCadastral,
      dataNascimento: resposta.dataNascimento,
      habilitaEnvioToken: resposta.habilitaEnvioToken,
      status: resposta.status,
      ppe: resposta.ppe,
      assinaDigital: resposta.assinaDigital
    });
    this.myControl.setValue(resposta.conjuge);
  }

  goPopulateOptios(nome: string) {

    this.global.getListarNomes('Participante/listarNomes/'+nome).subscribe(resposta => {
      this.options = resposta;
    });

  }

  
}


