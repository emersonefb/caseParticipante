package br.com.efb.controller.util;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.*;
import org.hibernate.usertype.UserType;



public class IdentifierLongType implements UserType {

	public Class<Long> returnedClass() {
		return Long.class;
	}

	public int[] sqlTypes() {
		return new int[] { Types.INTEGER };
	}

	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
		Long s = rs.getLong(names[0]);
		if (new Long(0).equals(s)) {
			return null;
		}
		return s; 
	}

	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
		if (null == value) {
			st.setNull(index, sqlTypes()[0]);
		} else {
			st.setLong(index, (Long) value);
		}
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		if(x==null)
		{
			return false;
		}
		return x.equals(y);
	}

	public int hashCode(Object x) throws HibernateException {
		assert (x != null);
		return x.hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
		return null;
	}

	@Override
	public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {

	}

	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return original;
	}

	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return cached;
	}

	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	public boolean isMutable() {
		return false;
	}

}