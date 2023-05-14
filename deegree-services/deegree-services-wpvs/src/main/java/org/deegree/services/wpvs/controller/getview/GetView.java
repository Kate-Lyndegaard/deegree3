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

package org.deegree.services.wpvs.controller.getview;

import java.awt.Color;
import java.util.List;

import org.deegree.cs.coordinatesystems.ICRS;
import org.deegree.geometry.Envelope;
import org.deegree.rendering.r3d.ViewParams;

/**
 * The <code>GetView</code> class TODO add class documentation here.
 *
 * @author <a href="mailto:bezema@lat-lon.de">Rutger Bezema</a>
 * @author last edited by: $Author$
 * @version $Revision$, $Date$
 *
 */
public class GetView {

	private final String id;

	private final String version;

	private final ICRS coordinateSystem;

	private final Envelope requestedBBox;

	private final ViewParams viewParameters;

	private final GetViewResponseParameters responseParameters;

	private final GetViewSceneParameters sceneParameters;

	/**
	 * @param id
	 * @param version
	 * @param coordinateSystem
	 * @param requestedBBox
	 * @param viewParameters
	 * @param responseParameters
	 * @param sceneParameters
	 */
	public GetView(String id, String version, ICRS coordinateSystem, Envelope requestedBBox, ViewParams viewParameters,
			GetViewResponseParameters responseParameters, GetViewSceneParameters sceneParameters) {
		this.id = id;
		this.version = version;
		this.coordinateSystem = coordinateSystem;
		this.requestedBBox = requestedBBox;
		this.viewParameters = viewParameters;
		this.responseParameters = responseParameters;
		this.sceneParameters = sceneParameters;

	}

	/**
	 * @return the datasets
	 */
	public final List<String> getDatasets() {
		return sceneParameters.getDatasets();
	}

	/**
	 * @return the quality
	 */
	public final double getQuality() {
		return responseParameters.getQuality();
	}

	/**
	 * @return the transparent
	 */
	public final boolean isTransparent() {
		return responseParameters.isTransparency();
	}

	/**
	 * @return the outputFormat
	 */
	public final String getOutputFormat() {
		return responseParameters.getFormat();
	}

	/**
	 * @return the backgroundColor
	 */
	public final Color getBackgroundColor() {
		return sceneParameters.getBgColor();
	}

	/**
	 * @return the exceptionFormat
	 */
	public final String getExceptionFormat() {
		return responseParameters.getExceptionFormat();
	}

	/**
	 * @return the elevationModel
	 */
	public final String getElevationModel() {
		return sceneParameters.getElevationModel();
	}

	/**
	 * @return the boundingBox
	 */
	public final Envelope getBoundingBox() {
		return requestedBBox;
	}

	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}

	/**
	 * @return the version
	 */
	public final String getVersion() {
		return version;
	}

	/**
	 * @return the coordinateSystem
	 */
	public final ICRS getCoordinateSystem() {
		return coordinateSystem;
	}

	/**
	 * @return the responseParameters
	 */
	public final GetViewResponseParameters getResponseParameters() {
		return responseParameters;
	}

	/**
	 * @return the sceneParameters
	 */
	public final GetViewSceneParameters getSceneParameters() {
		return sceneParameters;
	}

	/**
	 * @return the calculated viewparameters of this {@link GetView} request.
	 */
	public final ViewParams getViewParameters() {
		return viewParameters;
	}

}
