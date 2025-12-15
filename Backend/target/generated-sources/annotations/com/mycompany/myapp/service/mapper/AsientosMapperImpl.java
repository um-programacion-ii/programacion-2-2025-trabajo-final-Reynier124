package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Asientos;
import com.mycompany.myapp.domain.Sesion;
import com.mycompany.myapp.domain.Venta;
import com.mycompany.myapp.service.dto.AsientosDTO;
import com.mycompany.myapp.service.dto.SesionDTO;
import com.mycompany.myapp.service.dto.VentaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-15T14:36:50-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class AsientosMapperImpl implements AsientosMapper {

    @Override
    public Asientos toEntity(AsientosDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Asientos asientos = new Asientos();

        asientos.setId( dto.getId() );
        asientos.setFila( dto.getFila() );
        asientos.setColumna( dto.getColumna() );
        asientos.setPersona( dto.getPersona() );
        asientos.setEstado( dto.getEstado() );
        asientos.venta( ventaDTOToVenta( dto.getVenta() ) );
        asientos.sesion( sesionDTOToSesion( dto.getSesion() ) );

        return asientos;
    }

    @Override
    public List<Asientos> toEntity(List<AsientosDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Asientos> list = new ArrayList<Asientos>( dtoList.size() );
        for ( AsientosDTO asientosDTO : dtoList ) {
            list.add( toEntity( asientosDTO ) );
        }

        return list;
    }

    @Override
    public List<AsientosDTO> toDto(List<Asientos> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AsientosDTO> list = new ArrayList<AsientosDTO>( entityList.size() );
        for ( Asientos asientos : entityList ) {
            list.add( toDto( asientos ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Asientos entity, AsientosDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getFila() != null ) {
            entity.setFila( dto.getFila() );
        }
        if ( dto.getColumna() != null ) {
            entity.setColumna( dto.getColumna() );
        }
        if ( dto.getPersona() != null ) {
            entity.setPersona( dto.getPersona() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
        if ( dto.getVenta() != null ) {
            if ( entity.getVenta() == null ) {
                entity.venta( new Venta() );
            }
            ventaDTOToVenta1( dto.getVenta(), entity.getVenta() );
        }
        if ( dto.getSesion() != null ) {
            if ( entity.getSesion() == null ) {
                entity.sesion( new Sesion() );
            }
            sesionDTOToSesion1( dto.getSesion(), entity.getSesion() );
        }
    }

    @Override
    public AsientosDTO toDto(Asientos s) {
        if ( s == null ) {
            return null;
        }

        AsientosDTO asientosDTO = new AsientosDTO();

        asientosDTO.setVenta( toDtoVentaId( s.getVenta() ) );
        asientosDTO.setSesion( toDtoSesionId( s.getSesion() ) );
        asientosDTO.setId( s.getId() );
        asientosDTO.setFila( s.getFila() );
        asientosDTO.setColumna( s.getColumna() );
        asientosDTO.setPersona( s.getPersona() );
        asientosDTO.setEstado( s.getEstado() );

        return asientosDTO;
    }

    @Override
    public VentaDTO toDtoVentaId(Venta venta) {
        if ( venta == null ) {
            return null;
        }

        VentaDTO ventaDTO = new VentaDTO();

        ventaDTO.setId( venta.getId() );

        return ventaDTO;
    }

    @Override
    public SesionDTO toDtoSesionId(Sesion sesion) {
        if ( sesion == null ) {
            return null;
        }

        SesionDTO sesionDTO = new SesionDTO();

        sesionDTO.setId( sesion.getId() );

        return sesionDTO;
    }

    protected Venta ventaDTOToVenta(VentaDTO ventaDTO) {
        if ( ventaDTO == null ) {
            return null;
        }

        Venta venta = new Venta();

        venta.setId( ventaDTO.getId() );
        venta.setVentaIdCatedra( ventaDTO.getVentaIdCatedra() );
        venta.setFechaVenta( ventaDTO.getFechaVenta() );
        venta.setPrecioVenta( ventaDTO.getPrecioVenta() );
        venta.setResultado( ventaDTO.getResultado() );
        venta.setDescripcion( ventaDTO.getDescripcion() );
        venta.setCantidadAsientos( ventaDTO.getCantidadAsientos() );
        venta.setEstado( ventaDTO.getEstado() );

        return venta;
    }

    protected Sesion sesionDTOToSesion(SesionDTO sesionDTO) {
        if ( sesionDTO == null ) {
            return null;
        }

        Sesion sesion = new Sesion();

        sesion.setId( sesionDTO.getId() );
        sesion.setToken( sesionDTO.getToken() );
        sesion.setEstadoFlujo( sesionDTO.getEstadoFlujo() );
        sesion.setEventoSeleccionado( sesionDTO.getEventoSeleccionado() );
        sesion.setAsientosSeleccionados( sesionDTO.getAsientosSeleccionados() );
        sesion.setUltimaActividad( sesionDTO.getUltimaActividad() );
        sesion.setExpiraEn( sesionDTO.getExpiraEn() );

        return sesion;
    }

    protected void ventaDTOToVenta1(VentaDTO ventaDTO, Venta mappingTarget) {
        if ( ventaDTO == null ) {
            return;
        }

        if ( ventaDTO.getId() != null ) {
            mappingTarget.setId( ventaDTO.getId() );
        }
        if ( ventaDTO.getVentaIdCatedra() != null ) {
            mappingTarget.setVentaIdCatedra( ventaDTO.getVentaIdCatedra() );
        }
        if ( ventaDTO.getFechaVenta() != null ) {
            mappingTarget.setFechaVenta( ventaDTO.getFechaVenta() );
        }
        if ( ventaDTO.getPrecioVenta() != null ) {
            mappingTarget.setPrecioVenta( ventaDTO.getPrecioVenta() );
        }
        if ( ventaDTO.getResultado() != null ) {
            mappingTarget.setResultado( ventaDTO.getResultado() );
        }
        if ( ventaDTO.getDescripcion() != null ) {
            mappingTarget.setDescripcion( ventaDTO.getDescripcion() );
        }
        if ( ventaDTO.getCantidadAsientos() != null ) {
            mappingTarget.setCantidadAsientos( ventaDTO.getCantidadAsientos() );
        }
        if ( ventaDTO.getEstado() != null ) {
            mappingTarget.setEstado( ventaDTO.getEstado() );
        }
    }

    protected void sesionDTOToSesion1(SesionDTO sesionDTO, Sesion mappingTarget) {
        if ( sesionDTO == null ) {
            return;
        }

        if ( sesionDTO.getId() != null ) {
            mappingTarget.setId( sesionDTO.getId() );
        }
        if ( sesionDTO.getToken() != null ) {
            mappingTarget.setToken( sesionDTO.getToken() );
        }
        if ( sesionDTO.getEstadoFlujo() != null ) {
            mappingTarget.setEstadoFlujo( sesionDTO.getEstadoFlujo() );
        }
        if ( sesionDTO.getEventoSeleccionado() != null ) {
            mappingTarget.setEventoSeleccionado( sesionDTO.getEventoSeleccionado() );
        }
        if ( sesionDTO.getAsientosSeleccionados() != null ) {
            mappingTarget.setAsientosSeleccionados( sesionDTO.getAsientosSeleccionados() );
        }
        if ( sesionDTO.getUltimaActividad() != null ) {
            mappingTarget.setUltimaActividad( sesionDTO.getUltimaActividad() );
        }
        if ( sesionDTO.getExpiraEn() != null ) {
            mappingTarget.setExpiraEn( sesionDTO.getExpiraEn() );
        }
    }
}
