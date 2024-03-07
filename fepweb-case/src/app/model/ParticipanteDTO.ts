import { EstadoDTO } from "./EstadoDTO";

export interface ParticipanteDTO {
  nome?: string;
  assinaDigital?:boolean;
  celular?:string;
  codigo?:number;
  codigoExterno?:string;
  condicaoPessoal?:string;
  conjuge?:string;
  cpf?:string;
  cpfAplicavel?:boolean
  dataNascimento?:string;
  documentoIdentificacao?:string;
  email?:string;
  enderecoList?:[EstadoDTO];
  estadoCivil?:string;
  habilitaEnvioToken?:boolean;
  obsSemImpact?:string;
  ppe?:boolean;
  sexo?:string;
  status?:boolean;
  telefone?:string;
  validateFichaCadastral?:string;
}