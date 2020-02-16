package com.footfisi.tienda.transform;

/**
 * @param <T1> Model
 * @param <T2> Form
 */
public interface TransformForm <T1,T2>{
	public T1 transformFM(T2 oForm);

}
