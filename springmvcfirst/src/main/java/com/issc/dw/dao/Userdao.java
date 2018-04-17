package com.issc.dw.dao;

import com.issc.dw.model.User;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userdao extends JpaRepository<User,Integer> {
    User findByName(String name);
}
