package com.footfisi.tienda.transform;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.entity.MantProducto;
import com.footfisi.tienda.entity.MantProductoTalla;
import com.footfisi.tienda.entity.MantCategoria;
import com.footfisi.tienda.entity.MantTalla;
import com.footfisi.tienda.model.ProductoModel;
import com.footfisi.tienda.model.TallaModel;

@Component("productoTransform")
public class ProductoTransform implements Transform<ProductoModel, MantProducto> {

	@Override
	public MantProducto transformME(ProductoModel oModel) {
		if (oModel != null) {
			MantCategoria oEntityCategoria = new MantCategoria();
			oEntityCategoria.setIdCategoria(oModel.getIdCategoria());

			MantProducto oEntityProducto = new MantProducto();
			oEntityProducto.setIdProducto(oModel.getIdProducto());
			oEntityProducto.setMantProductoCategoria(oEntityCategoria);
			oEntityProducto.setVdescripcion(oModel.getsDescripcion());
			oEntityProducto.setVnombre(oModel.getsNombre());
			oEntityProducto.setNcantidad(oModel.getnCantidad());
			oEntityProducto.setNprecioUnitario(BigDecimal.valueOf(oModel.getnPrecioUnitario()));
			oEntityProducto.setVfoto(oModel.getsFoto());

			return oEntityProducto;
		}
		return null;
	}

	@Override
	public List<MantProducto> transformME(List<ProductoModel> lModel) {
		if (lModel != null) {
			List<MantProducto> lEntityProducto = new ArrayList<>();

			for (ProductoModel model : lModel) {
				lEntityProducto.add(transformME(model));
			}

			return lEntityProducto;
		}
		return null;
	}

	@Override
	public ProductoModel transformEM(MantProducto oEntity) {
		if (oEntity != null) {
			ProductoModel oModelProducto = new ProductoModel();
			oModelProducto.setIdProducto(oEntity.getIdProducto());

			oModelProducto.setIdCategoria(oEntity.getMantProductoCategoria().getIdCategoria());
			oModelProducto.setsMarca(oEntity.getMantProductoCategoria().getVmarca());
			oModelProducto.setsGenero(oEntity.getMantProductoCategoria().getVgenero());
			oModelProducto.setsTipo(oEntity.getMantProductoCategoria().getVtipo());
			
			List<TallaModel> lModelTalla = new ArrayList<>();

			for(MantProductoTalla auxiliar : oEntity.getMantTallas()) {
				TallaModel oModelTalla = new TallaModel();
				oModelTalla.setnIdTalla(auxiliar.getMantTalla().getIdTalla());
				oModelTalla.setsDescripcion(auxiliar.getMantTalla().getVdescripcion());
				
				lModelTalla.add(oModelTalla);
			}
			oModelProducto.setlTallas(lModelTalla);
			
			oModelProducto.setsNombre(oEntity.getVnombre());
			oModelProducto.setsDescripcion(oEntity.getVdescripcion());
			oModelProducto.setnCantidad(oEntity.getNcantidad());
			oModelProducto.setnPrecioUnitario(oEntity.getNprecioUnitario().intValue());
			oModelProducto.setnCantidad(oEntity.getNcantidad());
			oModelProducto.setsFoto(oEntity.getVfoto());

			return oModelProducto;
		}
		return null;
	}

	@Override
	public List<ProductoModel> transformEM(List<MantProducto> lEntity) {
		if (lEntity != null) {
			List<ProductoModel> lModelProducto = new ArrayList<>();

			for (MantProducto entity : lEntity) {
				lModelProducto.add(transformEM(entity));
			}

			return lModelProducto;
		}
		return null;
	}

}
