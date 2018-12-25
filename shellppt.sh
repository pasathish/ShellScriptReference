#!/bin/bash
#Slide 4

: 'Hi this a demo shell script
try by your self to know more' 
echo -e "\x1b[35m\x1b[1mWelcome to shell script session\x1b[37m"
echo "#!/bin/bash"
read
echo -e "\x1b[36m"
#---------------------------------System Variables---------------------------------
funsysVar(){
echo -e "\x1b[31m\x1b[1mCommon Shell Scripts"
echo -e "\x1b[32m 1.Bourne shell(sh)\n 2.Korn shell(ksh)\n 3.C shell(csh)\n 4.Bash(bash)\
\n 5.Remote shell(rsh)\n 6.Secure shell(ssh)"
read
echo -e "\x1b[31mIn Linux use the below command \n \x1b[32m cat  /etc/shells"
read
echo -e "\x1b[31mCommand to dispaly system variables"
echo -e "\x1b[32m 1.set \n 2.env \n 3.printenv"
echo -e "\x1b[31mExecuting  printenv command \x1b[32m"
read
read
printenv
echo -e "\x1b[37m"
read 
clear
}
#---------------------------------User Define Variables---------------------------
userDefinefun(){
echo -e "\x1b[31mUser Define variables : \x1b[37m"
echo -e "Variable name should start with alphabet or underscore and followed by any character and Special character are not allowed except “_”. \x1b[32m"
echo "abc1=5"
abc1=5
echo -e "echo \$abc1 "
echo $abc1
echo "_abc=10"
_abc=10
echo -e "echo \$_abc "
echo $_abc
echo -e "\x1b[31m2abc1=5"
echo -e "\x1b[34m"
2abc1=5
echo -e "\x1b[31m"
}
#---------------------------------read-------------------------------------------
readfun(){
echo -e "\x1b[31mUser Interactive shell script:"
echo -e "\x1b[37mread command"
echo -e "\x1b[31mSingle Input:"
echo -e "\x1b[37mread var1"
read var1
echo -e "echo \$var1"
echo $var1
echo -e "\x1b[31mMultiple Input:"
echo -e "\x1b[37mread var1 var2 var3 var4"
read var1 var2 var3 var4
echo -e "echo \$var1 \$var2 \$var3 \$var4"
echo $var1 $var2 $var3 $var4
echo -e "\x1b[31mReading Input with print statement:"
echo -e "\x1b[37mread  -p  \“Enter the value:\" var1"
read -p "Enter the value:" var1
echo -e "echo \$var1"
echo $var1
echo -e "read  -sp  \“Enter the password:\""
read -sp "Enter the password:" var1
echo $var1
}
#-------------------------------Array--------------------------------------
arrayfun(){
echo -e "\x1b[31mArrays in shell:"
echo -e "\x1b[32mSyntax:\narray_name=(value1 value2 value3 …..valuen)\x1b[37m"
echo "array_name=( 1 2 3 4 5 )"
array_name=( 1 2 3 4 5 )
echo -e "\x1b[32mPrint length of an array =>  echo \${#array_name[@]}\x1b[37m"
echo ${#array_name[@]}
echo -e "\x1b[32mPrint all elements in an array => echo \${array_name[@]}\x1b[37m"
echo ${array_name[@]}
echo -e "\x1b[32mAccessing elements through indexing => echo \${array_name[1]}\x1b[37m"
echo ${array_name[1]}
echo -e "\x1b[32mInserting Element at a particular index =>echo array_name[2]=12\x1b[37m"
echo array_name[2]=12
echo ${array_name[@]}
echo -e "\x1b[32mPrint indexs of an array=>echo \${!array_name[@]}\x1b[37m"
echo ${!array_name[@]}
echo -e "\x1b[31mHow to read an Array from user\x1b[37m"
echo "read -a array"
read -a  array;
echo "\${array[@]}"
echo ${array[@]}
}
#------------------------------Passing Argument to shell script-----------
shellfun(){
echo -e "\x1b[31mPassing Argument to shell script\x1b[37m"
echo -e "sh shell.sh tom mark john"
echo "args=("\$\@")"
args=("$@")
echo ${args[@]}
echo "echo \$1 \$2 \$3"
echo $1 $2 $3
}
#------------------------------Arithematic Operation---------------------
arithematicfun(){
num1=1;num2=2;
echo -e "\x1b[31mArithematic Operation\x1b[37m"
echo -e "\x1b[32mType 1:\x1b[37m"
echo -e "echo \$(( num1 + num2 ))"
echo $(( num1 + num2 ))
echo -e "\x1b[32mType 2:\x1b[37m"
echo -e "echo \$( expr $num1 + $num2 )"
echo $( expr $num1 + $num2 )
echo -e "echo \$( expr $num1 - $num2 )"
echo $( expr $num1 - $num2 )
echo -e "echo \$( expr $num1 \* $num2 )"#***
echo $( expr $num1 \* $num2 )
echo -e "echo \$( expr $num1 / $num2 )"
echo $( expr $num1 / $num2 )
echo -e "echo \$( expr $num1 % $num2 )"
echo $( expr $num1 % $num2 )
read
echo -e "\x1b[32mUse bc command for decimal calculations \x1b[37m"
cat bc.txt
# while IFS= read line
# do
# $line
# done < bc.txt
}
#-------------------------------Relational operator--------------------
relationfun(){
cat relational1.txt 
read  
cat relational2.txt
read  
cat relational3.txt
read  
cat relational4.txt
}
#-------------------------------Logical operator--------------------
logicalfun(){
echo -e "\x1b[31mLogical operator\x1b[37m"
echo -e "\x1b[32mAND\x1b[37m"
cat logicalOperator1.txt 
read 
echo -e "\x1b[32mOR\x1b[37m"
cat logicaloperator2.txt
}
#------------------------------- IF and Else ----------------------
ifelsefun(){
cat if.txt
read  
echo -e "\x1b[33mOutPut :\x1b[37m"
if [ 8 -gt 7 ]
then
	echo "True"
fi

read  
cat ifelse.txt
read  
echo -e "\x1b[33mOutPut :\x1b[37m"
if [ 8 -gt 7 ]
then
	echo "True"
else
	echo "False"
fi

read  
cat elif.txt
read  
echo -e "\x1b[33mOutPut :\x1b[37m"
if (( 6 > 7 ))
then
	echo "Condition 1 true"
elif [[ 7 > 6 ]]
then
	echo "Condition 2 true"
else
	echo "Nothing is true"
fi
}
#------------------------------------CASE STATEMENT---------------------
casefun(){
echo -e "\x1b[31mCase Statement \x1b[37m"
cat case.txt
read 
echo -e "\x1b[33mOutPut :\x1b[37m" 
read  -p "Enter a character"  char
case  $char in 
[a-z])
	printf  “lower\ case\ Letter” ;;
[A-Z])
	printf  “Upper\ case\ Letter” ;;
[0-9])
	printf  “Numbers” ;;
*)
	printf  “Special\ Character” ;;
esac
}
#-----------------------------------Loop Statement ---------------------
loopfun(){
echo -e "\x1b[31mLooping Statement \x1b[37m"
cat loop.txt
}
#------------------------------------ while -----------------------------
whilefun(){
echo -e "\x1b[31mWhile Statement \x1b[37m"
cat while.txt
read  
N=0
while [ $N -lt 10 ] 
do
	echo “The current value of N is $N”
	sleep 1
	(( N++ ))
done
read
echo -e "\x1b[31mWhile for reading a file \x1b[37m"
cat whilefileRead.txt
read  
echo -e "\x1b[33mOutPut :\x1b[37m"
while read line
do
  echo $line
done < file1.txt
read
}
#-----------------------------For------------------------------
forfun(){
echo -e "\x1b[31mFor statement \x1b[37m"
echo -e "\x1b[32mType 1:\x1b[37m"
cat for1.txt
read
echo -e "\x1b[33mOutPut :\x1b[37m"  
for value in  1 2 3 4
do
 echo $value 
done
read
echo -e "\x1b[32mType 2:\x1b[37m"
cat for2.txt
read  
echo -e "\x1b[33mOutPut :\x1b[37m"
for value in *
do
 echo $value 
done
read 
echo -e "\x1b[32mType 3:\x1b[37m" 
cat for3.txt
read  
echo -e "\x1b[33mOutPut :\x1b[37m"
for (( n=0; n < 5 ; n++))
do
  echo $n
done
read  
echo -e "\x1b[32mType 4:\x1b[37m"
cat for4.txt
read  
echo "{1..10} bashVersion>3"
echo "{1..10..2} bashVersion>4"
echo -e "\x1b[33mOutPut :\x1b[37m"
for val in {1..10..2}
do
	echo $val
done
read
}
#------------------------------until---------------------------------
untilfun(){
echo -e "\x1b[31mUntil statement\x1b[37m"
cat until.txt
read  
echo -e "\x1b[33mOutPut :\x1b[37m"
N=0
until [[ $N -eq 10 ]] 
do
	echo "The current value of N is $N"
	sleep 1
	(( N++ ))
done
}
#-------------------------------select loop------------------------
selectfun(){
echo -e "\x1b[31mSelect Statement\x1b[37m"
cat select.txt
read  
echo -e "\x1b[33mOutPut :\x1b[37m"
select val in select1 select2 select3 exit
do
  if [[ "$val" == "exit" ]]
  then
		exit
  else 
		echo "you selected  $val"
  fi
done
}
#------------------------------break an continue--------------------
breakfun(){
echo -e "\x1b[31mbreak and continue\x1b[37m"
}
#------------------------------ function --------------------------
fun(){
echo -e "\x1b[31mFunctions  :\x1b[37m"
echo "Functions"
cat function.txt
read  
echo -e "\x1b[33mOutPut  :\x1b[37m"
function hello(){
	echo $1 $2
}
quit(){
	echo "exit"
}
hello "Hello" "World"
quit
}
#------------------------------ local and global ------------------
localglobalfun(){
echo -e "\x1b[31mLocal and Global Variables\x1b[37m"
cat globalVAriable.txt
read  
echo -e "\x1b[33mOutPut   :\x1b[37m"
name=“AAAAAAA” # Global Variable

Print() {
          local name=“bbbb” # Local Variable
          echo Inside print $name #Inside print  bbbb     
}
echo $name  # AAAAAA
Print 
echo $name # AAAAAA
}
#------------------------------ Readonly --------------------------
readonlyfun(){
echo -e "\x1b[31mRead Only\x1b[37m"
cat readonly.txt
read  
echo -e "\x1b[33mOutPut   :\x1b[37m"
var=31;
readonly var;
# var=50;#Throws error
fun(){
     return  22;
}
readonly fun;
readonly -f # Display List of read only function
readonly -p # Display List of read only  variables
}

funArray=( "funsysVar" "userDefinefun" "readfun" "arrayfun" "shellfun" "arithematicfun" "relationfun" "logicalfun" "ifelsefun" "casefun" "loopfun" "whilefun" "forfun" "untilfun" "selectfun" "breakfun" "fun" "localglobalfun" "readonlyfun" "exit" )
select val in ${funArray[@]}
do
	if [[ "$val" == "exit" ]]
	  then
			exit
	fi
	echo -e "\x1b[37m"
	val=${val#*.}
	$val "tom" "mark" "john" 
	echo -e "\x1b[36m"
  
done
