Steps to run this local
1. git clone https://github.com/jenithainbaraj-ai/adk-sample
2. mvn build
3. add GOOGLE_API_KEY in your settings.(I used intelliJidea so used Edit configurations in Run)
4. mvn compile exec:java -Dexec.mainClass="com.example.agent.AgentCliRunner"
5. Added SearchAgent and Grammar Agent. Uncomment any one of the agent to run this main class..

          
         1) InMemoryRunner runner = new InMemoryRunner(GrammarAgent.ROOT_AGENT);
            When given a prompt in console, give as Correct, then enter "Teh RFP has been recieved"
            Agent will reply correcting it as "The RFP has been received"
            You can add your own grammar corrections in GrammarAgent.java.
   
         2) InMemoryRunner runner = new InMemoryRunner(SearchAgent.ROOT_AGENT);
            For now Search options just give three top options that I have provided in SearchAgent.java.
   
