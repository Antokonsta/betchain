pragma solidity ^0.4.16;


contract MatchContract
{
	address public initiator;
   	address public opposer;
        string public left;
	string public right;
        uint256 public leftRes;
	uint256 public rightRes;

    
    
    function MatchContract(
	address _initiator,
	address _opposer,
        string _left,
	string _right
        ) 
    {   
        initiator = _initiator;
	opposer = _opposer;
	left = _left;
	right = _right;
    }
    
    function getWinner() constant returns (string x)
    {
        if (leftRes > rightRes) { return "left"; }
        if (leftRes == rightRes) { return "draw"; }
        return "right";
    }


    function setResult(uint256 leftResult,uint256 rightResult)
  {
	leftRes = leftResult;
	rightRes = rightResult;
  }
    
}