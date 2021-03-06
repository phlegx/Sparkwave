/*
 * Copyright (c) 2011, University of Innsbruck, Austria.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * You should have received a copy of the GNU Lesser General Public License along
 * with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package at.sti2.spark.core.triple;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Immutable RDFURIReference
 * @author srdjankomazec
 * @author michaelrogger
 *
 */
public final class RDFURIReference extends RDFValue {

	private static final long serialVersionUID = -900633337817042617L;
	
	private final String iri;
	
	// caching hashCode
	private int hashCode = 0;
	
	/**
	 * Private constructor, use RDFLiteral.Factory.createLiteral()
	 */
	protected RDFURIReference(final String iri){
		this.iri = iri;
	}
	
	/**
	 * Private constructor, use RDFLiteral.Factory.createLiteral()
	 */
	protected RDFURIReference(final String namespace, final String name){
		this.iri = namespace+name;
	}

	public String getValue() {
		return iri;
	}
	
	@Override
	public boolean equals(Object that){
		
		//reference check (fast)
		if(this == that) return true;
		
		//type check and null check
		if(!(that instanceof RDFURIReference)) return false;
		
		RDFURIReference uri = (RDFURIReference)that;
		return this.iri.equalsIgnoreCase(uri.iri);
	}
	
	@Override
	public int hashCode() {
		if (hashCode == 0) {
			hashCode = new HashCodeBuilder(17, 37).append(iri).toHashCode();
		}
		return hashCode;
	}
	
	public String toString(){
		return iri.toString();
	}
	
	@Override
	public String formatString(){
		return "<"+iri.toString()+">";
	}
	
	public static class Factory{
		
		public static RDFURIReference createURIReference(final String iri){
			return new RDFURIReference(iri);
		}
	}
}
