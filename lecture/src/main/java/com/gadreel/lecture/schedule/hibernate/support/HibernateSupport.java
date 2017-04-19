/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Supportive class to provide necessary Hibernate functionalities
 */
package com.gadreel.lecture.schedule.hibernate.support;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateSupport {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session = null;
	
	/**
	 * Returns a hibernate database session
	 * @return a {@link Session} object
	 */
	public Session getSession() {
		session = sessionFactory.openSession();
		return session ;
	}
	
}
