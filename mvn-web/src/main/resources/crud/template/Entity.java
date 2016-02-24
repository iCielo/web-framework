package ${table.entityPackage};

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ${table.menuName}
 * @author cielo
 * @date ${now}
 */
@Entity
@Table(name = "${table.tableName}")
public class ${table.entity} implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	#foreach( $column in $columns )
		/**
		* ${column.label}
		*/
		#if( ${column.primaryKey} == 1 ) @Id #end
		@Column(name = "${column.columnName}"#if( ${column.length} ) ,  length = ${column.length} #end #if( ${column.primaryKey} ) , unique = true #end #if( ${column.nullable} == 0 ) , nullable = false #end)
		private ${column.javaType} ${column.javaName};
		
	#end
	
	#foreach( $column in $columns )
		/**
		* 设置 ${column.label}
		*/
		public void set${column.javaMethodName}(${column.javaType} ${column.javaName}){
			this.${column.javaName} = ${column.javaName};
		}
		
		/**
		* 获取 ${column.label}
		*/
		public ${column.javaType} get${column.javaMethodName}(){
			return this.${column.javaName};
		}
	#end
	
	@Override
	public String toString() {
		return "${table.entity} ["
				#foreach( $column in $columns )
				+ "${column.javaName}=" + ${column.javaName} #if( $foreach.last==false )+", "#end
				#end
				+ "]";
	}

}
