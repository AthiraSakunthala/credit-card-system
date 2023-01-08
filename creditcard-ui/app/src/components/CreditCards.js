import React,{useEffect,useState,useRef} from "react";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Table from 'react-bootstrap/Table';
import {TabContainer} from "react-bootstrap";
function CreditCards(){
    const numberRef = useRef();
    const nameRef = useRef();
    const limitRef = useRef();

    async function loadCreditCards() {
        let result = await fetch("http://localhost:8080/cards");
        result = await result.json();
        setCreditCards(result);
    }

    async function handleSubmit(event) {
        event.preventDefault();
        const number = numberRef.current.value;
        const name = nameRef.current.value;
        const limit = limitRef.current.value;

         let result= await fetch("http://localhost:8080/cards", {
            method : "POST",
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ "name": name,
                "number" : number,
                "limit": limit
            })});
        if(result.status===400){
            alert("Invalid input");
            console.info(result.statusMessage);
        }
        if(result.status===409){
            // console.log(result.prototype.body)
            alert("Credit card details are already added");
        }



    }
    const [creditcards,setCreditCards]=useState([]);
    useEffect(()=>{loadCreditCards()}
    );
    return(


                       <form className="credit-card" onSubmit= {handleSubmit}>
                           <h1>Credit Card System</h1>
                           <div className="input-group">
                               <label htmlFor="name">Name</label>
                               <input type="text" id="name" ref={nameRef}/>
                           </div>
                           <div className="input-group">
                               <label htmlFor="email">Card Number</label>
                               <input type="text" id="number" ref={numberRef} />
                           </div>
                           <div className="input-group">
                               <label htmlFor="limit">Limit</label>
                               <input type="number" id="limit" ref={limitRef} />
                           </div>
                           <button type="submit" className="submit-btn" >
                             Add
                         </button>

                           <div>
                               <div >
                                <TabContainer>
                                   <Table striped bordered hover size="sm" className="credit-card">
                                   <thead><tr>
                                       <td>Name</td>
                                       <td>Card Number</td>
                                       <td>Balance</td>
                                       <td>Limit</td>
                                   </tr>
                                   </thead>
                                   <tbody>

                                   {
                                       creditcards.map((item)=>
                                           <tr>
                                               <td>{item.name}</td>
                                               <td>{item.number}</td>
                                               <td>{item.balance}</td>
                                               <td>{item.limit}</td>
                                           </tr>
                                       )
                                   }
                                   </tbody>

                               </Table>
                                </TabContainer>
                               </div>
                           </div>
                   </form>

    )

}

export default CreditCards