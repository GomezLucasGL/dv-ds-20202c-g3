package ar.edu.davinci.dvds20202cg3.service;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.edu.davinci.dvds20202cg3.model.Item;

public interface ItemService {
    public List<Item> listAll();
    public Page<Item> list(Pageable pageable);
    public Optional<Item> findById(Long id);
    public Item save(Item item);
    public void delete(Item item);
    public void delete(Long id);
    public long count();


}
