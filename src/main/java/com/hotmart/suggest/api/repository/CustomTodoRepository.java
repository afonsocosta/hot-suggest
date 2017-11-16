package com.hotmart.suggest.api.repository;
import java.util.List;

import com.hotmart.suggest.api.entity.Cliente;
 
interface CustomTodoRepository {
 
    List<Cliente> findBySearchTerm(String searchTerm);
}