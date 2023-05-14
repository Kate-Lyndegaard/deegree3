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
package org.deegree.observation.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.deegree.observation.time.TimePeriod;

/**
 * This class is a collection of {@link Measurement}s.
 * 
 * @author <a href="mailto:tonnhofer@lat-lon.de">Oliver Tonnhofer</a>
 * @author <a href="mailto:ionita@lat-lon.de">Andrei Ionita</a>
 * @author last edited by: $Author$
 * 
 * @version $Revision$, $Date$
 * 
 */
public class MeasurementCollection implements Iterable<Measurement> {

    private final TimePeriod samplePeriod = new TimePeriod();

    private final List<Measurement> measurements = new LinkedList<Measurement>();

    private final List<Property> properties;

    /**
     * @param properties
     */
    public MeasurementCollection( Collection<Property> properties ) {
        this.properties = new ArrayList<Property>( properties );
    }

    /**
     * Add a new measurement to the collection.
     * 
     * @param measurement
     */
    public void add( Measurement measurement ) {
        samplePeriod.extend( measurement.getSamplingTime() );
        measurements.add( measurement );
    }

    @Override
    public String toString() {
        return String.format( "MeasurementCollection (n: %d) %s", measurements.size(), samplePeriod );
    }

    public Iterator<Measurement> iterator() {
        return measurements.iterator();
    }

    /**
     * @return the number of measurements in this collection
     */
    public int size() {
        return measurements.size();
    }

    /**
     * @return a list of all stored properties.
     */
    public List<Property> getProperties() {
        return new ArrayList<Property>( properties );
    }

    /**
     * @return the sampling time of this collection. The TimePeriod will contain all SamplingTimes of this collection.
     */
    public TimePeriod getSamplingTime() {
        return samplePeriod;
    }

}
