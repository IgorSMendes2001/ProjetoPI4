import React from "react";
export default function Menu(){
return(
    <View style={styles.container}>
    <Animatable.View animation={'fadeInLeft'}delay={500} style={styles.containerHeader} >
        <Text style={styles.message}> Seja Bem Vindo ! </Text>
        <Text style={styles.title}> UNIBUS </Text>
        {
            carregando ? <ActivityIndicator/>:(
                
            )
        }
    </Animatable.View>
    </View>
)
    }

    const styles = StyleSheet.create({
        container:{
            flex:1,
            backgroundColor:'#38a29d'
        },
        containerHeader:{
            marginTop:'14%',
            marginBottom: '8%',
            paddingStart:'5%',
        },
        message:{
            fontSize:28,
            fontWeight:"bold",
            color: '#FFF'
        },
        containerForm:{
            backgroundColor:'#FFF',
            flex:1,
            borderTopLeftRadius:25,
            borderTopRightRadius:25,
            paddingStart:'5%',
            paddingEnd:'5%'
        },
        title:{
            fontSize:20,
            marginTop:20,
        },
        button:{
            backgroundColor:'#38a29d',
            width:'100%',
            borderRadius:4,
            paddingVertical:8,
            marginTop:14,
            justifyContent:'center',
            alignItems:'center'
        },
        buttonText:{
            color:'#FFF',
            fontSize:18,
            fontWeight:'bold'
        },
        buttonRegister:{
            marginTop:14,
            alignSelf:'center'
        },
        registerText:{
            color:'#a1a1a1'
        }

    })
    