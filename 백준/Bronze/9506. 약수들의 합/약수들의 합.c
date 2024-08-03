#include<stdio.h>
#include<stdlib.h>
#include<string.h>

// n/2를 넘는 자기자신을 제외한 약수는 없다.

typedef struct node* node_ptr;

typedef struct node
{
    int div;
    node_ptr link;
}node;

void free_node(node_ptr head)
{
    node_ptr del_node;
    node_ptr next_node = head;
    while(1)
    {
        if(next_node->div == -1)
            break;
        del_node = next_node;
        next_node = next_node->link;
        free(del_node);
    }
}

void check(node_ptr head, int n)
{
    int sum = 0;
    node_ptr tmpnode;
    for(int i = n/2; i >= 1; i--)
    {
        if(n%i == 0)
        {
            tmpnode = (node_ptr)malloc(sizeof(node));
            tmpnode->link = head;
            tmpnode->div = i;
            head = tmpnode;
            sum+=i;
        }
    }
    tmpnode = head;
    if(sum == n)
    {        
        printf("%d = ",n);
        while(1)
        {
            printf("%d",tmpnode->div);
            tmpnode = tmpnode->link;
            if(tmpnode->div != -1)
                printf(" + ");
            else
            {
                printf("\n");
                break;
            }
        }
    }
    else
    {
        printf("%d is NOT perfect.\n",n);
    }
    free_node(head);
    return ;
}

int main(void)
{
    node_ptr HEAD;
    int n;
    
    HEAD = (node_ptr)malloc(sizeof(node));
    HEAD->link = NULL;
    HEAD->div = -1;
    while(1)
    {
        scanf("%d",&n);
        if(n == -1)
            break;
        else
            check(HEAD,n);
    }
    return 0;
}
