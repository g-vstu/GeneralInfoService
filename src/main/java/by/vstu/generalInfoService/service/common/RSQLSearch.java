package by.vstu.generalInfoService.service.common;

import by.vstu.generalInfoService.entity.Faculty;
import by.vstu.generalInfoService.entity.common.AbstractEntity;
import by.vstu.generalInfoService.service.common.rsql.CustomRsqlVisitor;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.springframework.data.jpa.domain.Specification;

public interface RSQLSearch<E extends AbstractEntity> {

    default Specification<E> getSpecifications(String query) {
        try {
            Node rootNode = new RSQLParser().parse(query);

            return (Specification<E>) rootNode.accept(new CustomRsqlVisitor<Faculty>());

        }catch (Exception e){
            throw new IllegalArgumentException("There are errors in the search query string");
        }
    }
}
