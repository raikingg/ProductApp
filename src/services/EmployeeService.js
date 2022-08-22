import axios from 'axios';

//const EMPLOYEE_API_BASE_URL = "http://localhost:8081/api/v1/employees";
const PRODUCT_API_BASE_URL = "http://localhost:9090/datapoem/product";
const USER_API_BASE_URL="";
class ProductService{
    getProducts(){
        return axios.get(PRODUCT_API_BASE_URL);
    }
    createEmployee(employee){
        return axios.post(PRODUCT_API_BASE_URL, employee);
    }
    getProductById(productId){
        return axios.get(PRODUCT_API_BASE_URL + '/'+productId);
    }
    updateEmployee(employee, employeeId){
        return axios.put(PRODUCT_API_BASE_URL+'/'+employeeId, employee);
    }
    deleteEmployee(employeeId){
        return axios.delete(PRODUCT_API_BASE_URL+'/'+employeeId);
    }
}
export default new ProductService()