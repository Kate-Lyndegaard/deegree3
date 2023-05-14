/*----------------------------------------------------------------------------
 This file is part of deegree, http://deegree.org/
 Copyright (C) 2001-2009 by:
 Department of Geography, University of Bonn
 and
 lat/lon GmbH

 This library is free software; you can redistribute it and/or modify it under
 the terms of the GNU Lesser General Public License as published by the Free
 Software Foundation; either version 2.1 of the License, or (at your option)
 any later version.
 This library is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 details.
 You should have received a copy of the GNU Lesser General Public License
 along with this library; if not, write to the Free Software Foundation, Inc.,
 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA

 Contact information:

 lat/lon GmbH
 Aennchenstr. 19, 53177 Bonn
 Germany
 http://lat-lon.de/

 Department of Geography, University of Bonn
 Prof. Dr. Klaus Greve
 Postfach 1147, 53001 Bonn
 Germany
 http://www.geographie.uni-bonn.de/deegree/

 e-mail: info@deegree.org
 ----------------------------------------------------------------------------*/

package org.deegree.layer.dims;

/**
 * <code>DimensionInterval</code>
 *
 * @author <a href="mailto:schmitz@lat-lon.de">Andreas Schmitz</a>
 * @author last edited by: $Author: aschmitz $
 * @version $Revision: 32241 $, $Date: 2011-10-21 15:06:29 +0200 (Fri, 21 Oct 2011) $
 * @param <T>
 * @param <U>
 * @param <V>
 */
public class DimensionInterval<T, U, V> {

	/***/
	public T min;

	/***/
	public U max;

	/***/
	public V res;

	/**
	 * @param min
	 * @param max
	 * @param res
	 */
	public DimensionInterval(T min, U max, V res) {
		this.min = min;
		this.max = max;
		this.res = res;
	}

	@Override
	public String toString() {
		return min + "/" + max + "/" + res;
	}

}
