#include<stdio.h> //printf
#include<stdlib.h> //exit
#include<unistd.h> //fork
#include<sys/types.h> //pid_t
#include<sys/wait.h> //wait
int main() {
int pid1;
int pid2;
int pid3;


if (pid1=fork()==0) { 
fork();
printf("je suis le processus fils de pid  %d , mon père est de pid %d  \n\n",getpid(),getppid());
exit(0);

 }

wait(0);
if (pid2=fork()==0) { 
fork()&&fork();
printf("je suis le processus fils de pid  %d , mon père est de pid %d  \n\n",getpid(),getppid());
exit(0); }


if (pid3=fork()==0) { 
printf("je suis le processus fils de pid  %d , mon père est de pid %d  \n\n",getpid(),getppid());
exit(0); }

return 0;
}
