import com.bigcorp.project.data.contract.AddressService;
import com.bigcorp.project.data.repository.AddressServiceImpl;

/**
 * Module en charge de l'accès aux données
 * @provides AddressService
 */
module com.bigcorp.project.data.repository {

	exports com.bigcorp.project.data.model;
	exports com.bigcorp.project.data.repository;
	
	//Attention, l'ouverture de ce package est nécessaire pour JPA 
	opens com.bigcorp.project.data.model;

	provides AddressService with AddressServiceImpl;

	requires transitive com.bigcorp.project.data.contract;

}