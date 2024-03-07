package br.com.efb.controller.api;

import br.com.efb.controller.dto.ParticipanteDTO;
import br.com.efb.controller.dto.ParticipantePageDTO;
import br.com.efb.controller.dto.ParticipanteSearchDTO;
import br.com.efb.controller.entity.Participante;
import br.com.efb.controller.mapper.impl.ParticipanteMapperImpl;
import br.com.efb.controller.util.AppException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(tags = {"Participante"})
@Path("/Participante")
public class ParticipanteAPI extends BaseResource {

    private static final Logger logger = Logger.getLogger(ParticipanteAPI.class);
    private ParticipanteDTO participanteDTO;

    private ParticipanteMapperImpl participanteMapper;

    /**
     * Adiciona o Token no Header
     * @param object
     * @return
     */
    private Response addTokenHeader(Object object) {
        return Response.ok().entity(object).header("tokenJWT", "toktok").build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Service executed without errors", response = ParticipanteDTO.class),
            @ApiResponse(code = 400, message = "There is errors on the validation of request input data", response = AppException.class),
            @ApiResponse(code = 500, message = "An internal error occurred", response = AppException.class)
    })
    @ApiOperation(value = "save",
            response = ParticipanteDTO.class)
    @Path("/cadastrar")
    public Response postSave(ParticipanteDTO participanteDTO) {
        try{

            participanteMapper = new ParticipanteMapperImpl();
            Participante participante = participanteMapper.dtoToEntity(participanteDTO);
            if (participanteServiceImpl !=null){
                Participante salvared = participanteServiceImpl.salvar(participante);
                this.participanteDTO = participanteMapper.entityToDTO(salvared);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return addTokenHeader(this.participanteDTO);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Service executed without errors", response = ParticipanteDTO.class),
            @ApiResponse(code = 400, message = "There is errors on the validation of request input data", response = AppException.class),
            @ApiResponse(code = 500, message = "An internal error occurred", response = AppException.class)
    })
    @ApiOperation(value = "save",
            response = ParticipanteDTO.class)
    @Path("/update")
    public Response putUpdate(ParticipanteDTO participanteDTO) {
        try{
            participanteMapper = new ParticipanteMapperImpl();
            Participante participante = participanteMapper.dtoToEntity(participanteDTO);
            if (participanteServiceImpl !=null){
                Participante salvared = participanteServiceImpl.salvar(participante);
                this.participanteDTO = participanteMapper.entityToDTO(salvared);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return addTokenHeader(this.participanteDTO);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Service executed without errors", response = ParticipanteDTO.class),
            @ApiResponse(code = 400, message = "There is errors on the validation of request input data", response = AppException.class),
            @ApiResponse(code = 500, message = "An internal error occurred", response = AppException.class)
    })
    @ApiOperation(value = "Find Groups User By ID",
            response = ParticipanteDTO.class)
    @Path("/deletar/{codigo}")
    public Response deletar(@PathParam("codigo") Long codigo) {

        try{
            if (participanteServiceImpl !=null){
                Participante participante = participanteServiceImpl.FindParticipantesById(codigo);
                participanteServiceImpl.delete(participante);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return addTokenHeader(null);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Service executed without errors", response = ParticipanteDTO.class),
            @ApiResponse(code = 400, message = "There is errors on the validation of request input data", response = AppException.class),
            @ApiResponse(code = 500, message = "An internal error occurred", response = AppException.class)
    })
    @ApiOperation(value = "List",
            response = ParticipanteDTO.class)
    @Path("/deletarLista")
    public Response deletarLista(List<Long> list) {

        try{
            for (Long id: list){
                participanteMapper = new ParticipanteMapperImpl();
                Participante participante = participanteServiceImpl.FindParticipantesById(id);
                if (participanteServiceImpl !=null){
                    participanteServiceImpl.delete(participante);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return addTokenHeader(null);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Service executed without errors", response = ParticipanteDTO.class),
            @ApiResponse(code = 400, message = "There is errors on the validation of request input data", response = AppException.class),
            @ApiResponse(code = 500, message = "An internal error occurred", response = AppException.class)
    })
    @ApiOperation(value = "Delete Groups By ID",
            response = ParticipanteDTO.class)
    @Path("/buscar/{codigo}")
    public Response getByCodigo(@PathParam("codigo") Long codigo) {
        try{

            participanteMapper = new ParticipanteMapperImpl();
            Participante participante = participanteServiceImpl.FindParticipantesById(codigo);
            this.participanteDTO = participanteMapper.entityToDTO(participante);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return addTokenHeader(this.participanteDTO);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Service executed without errors", response = ParticipantePageDTO.class),
            @ApiResponse(code = 400, message = "There is errors on the validation of request input data", response = AppException.class),
            @ApiResponse(code = 500, message = "An internal error occurred", response = AppException.class)
    })
    @ApiOperation(value = "Find By User",
            response = ParticipanteDTO.class)
    @Path("/listar")
    public Response findParticipante(ParticipanteSearchDTO searchDTO) {
        ParticipantePageDTO pageDTO = new ParticipantePageDTO();
        try{
            if (participanteServiceImpl !=null){
                pageDTO = participanteServiceImpl.FindParticipantesFiltersearch(searchDTO);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return addTokenHeader(pageDTO);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Service executed without errors", response = List.class),
            @ApiResponse(code = 400, message = "There is errors on the validation of request input data", response = AppException.class),
            @ApiResponse(code = 500, message = "An internal error occurred", response = AppException.class)
    })
    @ApiOperation(value = "Test Service",
            response = ParticipanteDTO.class)
    @Path("/listarNomes/{nome}")
    public Response testefbGrupo(@PathParam("nome") String nome) {
        List<String> nomes = new ArrayList<>();
        try{
            if (participanteServiceImpl !=null){
                List<Participante> participante = participanteServiceImpl.FindParticipantesLikeNome(nome);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return addTokenHeader(nomes);
    }

}
