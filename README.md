# AREP-Parcial2

## Problem
Design a microservices system prototype that includes a service (represented in the figure as Math Services) to compute the integer sequence. The sequence service should be deployed on at least two virtual EC2 instances. Additionally, implement a service proxy that receives the call requests from clients and delegates them to the two sequence service instances using a round-robin algorithm. The proxy should be deployed on a separate EC2 machine. Ensure that the addresses and ports of the service instances can be configured in the proxy using operating system environment variables. Finally, build a minimal web client with a form that receives the string and asynchronously invokes the single service on the PROXY. The client should be written in HTML and JS.

## Architecture
![image](https://github.com/user-attachments/assets/706775c3-a1fc-4a11-8abc-7e99bf20edb2)

### Aditional details about the API

Implement the services to respond to HTTP GET or POST request methods. They should use the specified function name, and the parameter must be passed in the query variable named `value`.

The proxy should delegate the call to the backend services. Both the proxy and the services should be implemented in Java using Spring.

### Example of a Call:

EC2  
`https://amazonxxx.x.xxx.x.xxx:{port}/lucasseq?value=13`

### Output:

The format of the output and response should be a JSON in the following format:

```json
{
  "operation": "Lucas Sequence",
  "input": 13,
  "output": "2, 1, 3, 4, 7, 11, 18, 29, 47, 76, 123, 199, 322, 521"
}
```

# Algorithm
![image](https://github.com/user-attachments/assets/ea45461d-53f6-4e3c-a221-93ca5f2401fd)

## Local Deployment

- Urls for Round Robin

![image](https://github.com/user-attachments/assets/997c2ee8-7790-43df-8c31-356b25631330)

- Browser Test

![image](https://github.com/user-attachments/assets/89c676b8-6e5a-4ea8-8ca6-8bbc2b0d5e00)

## AWS Deployment

- Environment Variables

![image](https://github.com/user-attachments/assets/e6a386fe-5306-448b-bba6-96841c2892bf)
![image](https://github.com/user-attachments/assets/9e2e99e6-1b0d-4c17-9653-24ef2d96a85a)

- EC2 Proxy

![image](https://github.com/user-attachments/assets/4910a1b2-b8c5-4dfa-af7d-cd522106c179)

- Round Robin

![image](https://github.com/user-attachments/assets/4aa9a429-b9a7-496b-9cb2-4940056de69f)

- EC2 Math 1

![image](https://github.com/user-attachments/assets/4533edcc-1b6a-494b-83e1-635265c63241)

- EC2 Math 2

![image](https://github.com/user-attachments/assets/f3e8db4d-ff20-4c71-be9e-264f1a6ed4a4)

## Authors
- *Juan David Contreras* | [AREP-Parcial2](https://github.com/jcontreras2693/AREP-Parcial2.git)
