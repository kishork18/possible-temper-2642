package com.masai.dao;

import java.util.List;

import com.masai.entity.Admin;
import com.masai.exceptions.RecordNotFoundException;
import com.masai.exceptions.SomthingWentWrongException;

public interface AdminDao {
 public void addAdmin(Admin admin) throws SomthingWentWrongException ;
 public void logInAdmin(String userName,String password)throws SomthingWentWrongException,RecordNotFoundException;
 public List<Admin> getAdminList()throws SomthingWentWrongException,RecordNotFoundException;
 public void deleteAdmin(int id) throws SomthingWentWrongException,RecordNotFoundException;
}
