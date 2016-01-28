/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	${now}</p>
 */
package ${table.servicePackage};

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${table.entityPackage}.${table.entity};
import com.lezic.core.orm.service.BaseService;

/**
 * @author cielo
 *
 */
@Service
@Transactional
public class ${table.service} extends BaseService<${table.entity}> {
}
