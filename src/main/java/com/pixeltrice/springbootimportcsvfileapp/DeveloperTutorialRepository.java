package com.pixeltrice.springbootimportcsvfileapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperTutorialRepository extends JpaRepository<Proveedores, Integer>{

}
