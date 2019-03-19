pragma solidity ^0.4.7; 
contract HelloWorld { 
	bytes32 _userName; 
	function setUserName(bytes32 userName) public returns(bytes32){ 
		_userName = userName; 
		return _userName; 
	} 
} 
