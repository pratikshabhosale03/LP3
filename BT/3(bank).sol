pragma solidity ^0.8.0;
contract bank{

mapping(address=>uint256)public balances;
function deposit(uint256 _amount)
public 
payable{
	balances[msg.sender]=_amount;
}

function withdraw(uint256 _amount)
public{
	require(balances[msg.sender]>=_amount,"Insufficient balance");
	balances[msg.sender]-=_amount;
}
function show()
public 
view 
returns(uint256){
	return balances[msg.sender];
}

}
