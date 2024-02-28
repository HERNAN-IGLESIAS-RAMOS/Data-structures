package estdatos;

public interface Poly {
	
	/**
	 * Inserta el termino de coeficiente y exponente especificados al
	 * polinomio. Si el exponente del termino a añadir ya existe en
	 * el polinomio, se acumulan los coeficientes.
	 * @param coef el coeficiente del termino a añdir
	 * @param exp la potencia del termino a añadir
	 * @return 0 si el termino con exponente exp no existía
     * o el coeficiente anterior, en caso contrario.
	 */
    public Double put(Integer exp, Double coef);
    
	/**
	 * Elimina del polinomio, si existe, el termino de potencia
	 * especificada.
	 * @param exp la potencia del termino a eliminar
	 * @return el valor del coeficiente del termino que se borra o null
	 * si el termino de la potencia dada no estaba en el polinommio 
	 */
	public Double remove(Integer exp);
	
	/**
	 * Retorna el coeficiente del termino de potencia especificada. Si
	 * no encuentra el termino retorna 0.
	 * @param exp la potencia del termino a buscar
	 * @return el coeficiente del termino de potencia especificada,
	 * si existe. En caso contrario 0.
	 */
	public Double coefficient (Integer exp);
		
	/**
	 * Retorna el grado del polinomio (0 si no hay términos)
	 * @return el grado del polinomio 
	 */
    public Integer degree();
    
     
	/**
	 * Retorna el resultado de evaluar el polinomio para un valor dado
	 * de la x
	 * @param x el valor de la x
	 * @return el resultado de avaluar el polinomio
	 */
    public Double evaluate(Integer x);
	
  

}
