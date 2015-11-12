package com.example.respositroy;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import com.example.entity.SysUser;

@Transactional
public interface SysUserRespositroy extends CrudRepository<SysUser, Long> {

}
