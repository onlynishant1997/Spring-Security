package com.epam.bank.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * The Class HibernateUtils.
 */
public class HibernateUtils {
	private static SessionFactory sessionFactory;
	private static Session session;
	static {
		sessionFactory = new Configuration().configure("com/epam/bank/hibernate.cfg.xml").buildSessionFactory();
	}

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}

	/**
	 * Close session.
	 */
	public static void closeSession() {
		session.close();
	}

	/**
	 * Close session factory.
	 */
	public static void closeSessionFactory() {
		sessionFactory.close();
	}

}