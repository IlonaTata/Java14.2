package ru.netology;
public class ProductRepository {
    private Product[] types = new Product[0];
    public Product findById(int id) {
        for (Product type : types) {
            if (type.getId() == id) {
                return type;
            }
        }
        return null;
    }


    public void save(Product type) {
       if(findById(type.getId()) == type) {
           throw new AlreadyExistsException(
                   "Element with id"  + type.getId() +  "exist"
           );
        }
        Product[] tmp = new Product[types.length + 1];
        for (int i = 0; i < types.length; i++) {
            tmp[i] = types[i];
        }
        tmp[tmp.length - 1] = type;
        types = tmp;
    }

    public Product[] findAll() {
        return types;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }

        Product[] tmp = new Product[types.length - 1];
        int copyToIndex = 0;
        for (Product type : types) {
            if (type.getId() != id) {
                tmp[copyToIndex] = type;
                copyToIndex++;
            }
        }
        types = tmp;
    }
}








