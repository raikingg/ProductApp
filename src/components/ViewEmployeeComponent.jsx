import React, { Component } from 'react';
import ProductService from '../services/EmployeeService';

class ViewEmployeeComponent extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            id: this.props.match.params.id,
            employee: {
                
            }
         }
         
    }
    componentDidMount(){
        ProductService.getProductById(this.state.id).then( res => {
            this.setState({employee: res.data});
        })
    }
    render() { 
        return ( <div>
            <br></br>
            <div className="card col-md-6 offset-md-3">
                <h3 className="text-center">View Product Details</h3>
                <div className="card-body">
                    <div className="row">
                        <label>Product Name: </label>
                        <div>{ this.state.employee.productName }</div>
                    </div>
                    <div className="row">
                        <label>Product Price: </label>
                        <div>{ this.state.employee.productPrice }</div>
                    </div>
                    <div className="row">
                        <label>Description: </label>
                        <div>{ this.state.employee.description }</div>
                    </div>
                   
                </div>
            </div>
        </div> );
    }
}
 
export default ViewEmployeeComponent;