pragma solidity ^0.8.0;

contract studentManagement{
	struct Student{
		int256 stud_id;
		string name;
		string department;
	}

	Student[] public students;

	function addStudent(int256 stud_id,string memory name,string memory department)
	public 
	{
		Student memory stud=Student(stud_id,name,department);
		students.push(stud);
	}
	function getStudent(int256 stud_id)
	public 
	view 
	returns(string memory,string memory){
		for(uint i=0;i<students.length;i++){
			Student memory stud=students[i];
			if(stud.stud_id==stud_id){
				return(stud.name,stud.department);
			}
		}return("not found","not found");
	}
	function getAllStudents()
	public 
	view 
	returns(Student[] memory){
		return students;
	}

	function deleteStudent(int256 stud_id)
	public 
	returns(bool){
		for(uint i=0;i<students.length;i++){
			if(students[i].stud_id==stud_id){
				students[i]=students[students.length-1];
				students.pop();
				return true;
			}
		}return false;
	}

}

